package by.belinvest.panel.admin.LDAP;

import java.util.*;

import javax.naming.*;
import javax.naming.directory.*;

import by.belinvest.panel.admin.LDAP.mappers.StaticMapper;
import by.belinvest.panel.admin.entity.Group;
import by.belinvest.panel.admin.entity.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.ldap.core.*;
import org.springframework.ldap.core.support.AbstractContextMapper;
import org.springframework.ldap.filter.EqualsFilter;
import org.springframework.ldap.support.LdapNameBuilder;
import org.springframework.security.ldap.DefaultLdapUsernameToDnMapper;
import org.springframework.security.ldap.LdapUsernameToDnMapper;
import org.springframework.stereotype.Component;


@Component
@PropertySource("classpath:LDAP.properties")
public class WlsLdapUserRepository  {

    @Value( "${domain}" )
    private String domain;



    private final LdapTemplate ldapTemplate;
    private final UserLDAPRepository userLDAPRepository;

    @Autowired
    public WlsLdapUserRepository(@Qualifier("ldapTemplate") LdapTemplate ldapTemplate,UserLDAPRepository userLDAPRepository) throws InvalidNameException {
        this.ldapTemplate = ldapTemplate;
        this.userLDAPRepository = userLDAPRepository;
    }

    LdapUsernameToDnMapper usernameMapper = new DefaultLdapUsernameToDnMapper("cn=people",
            "uid");

    public LdapTemplate getLdapTemplate() {
        return ldapTemplate;
    }

    public void deleteAttr(Name dn, String attrName) {
        List attributes = new ArrayList();
        Attribute attr = new BasicAttribute(attrName);
        ModificationItem item = new ModificationItem(3, attr);

        attributes.add(item);
        modify(dn, attributes);
    }

    protected void replaceAttr(Name dn, String attrName, String attrVal) {
        List attributes = new ArrayList();
        Attribute attr = new BasicAttribute(attrName);
        attr.add(attrVal);
        ModificationItem item = new ModificationItem(2, attr);

        attributes.add(item);
        modify(dn, attributes);
    }

    public void addAttr(Name dn, String attrName, String attrVal) {
        List attributes = new ArrayList();
        Attribute attr = new BasicAttribute(attrName);
        attr.add(attrVal);
        ModificationItem item = new ModificationItem(1, attr);

        attributes.add(item);
        modify(dn, attributes);
    }

    public void deleteUser(String username) {
        DistinguishedName dn = usernameMapper.buildDn(username);
        ldapTemplate.unbind(dn);
    }


    private void modify(Name dn, List<ModificationItem> attributes) {
        ModificationItem[] modificationItems = (ModificationItem[])attributes.toArray(new ModificationItem[0]);
        getLdapTemplate().modifyAttributes(dn, modificationItems);
        attributes.clear();
    }

    public Map<String, String[]> getAttrsStartsWith(Name dn, String opAttr) {
        return (Map)getLdapTemplate().lookup(dn, new String[] { opAttr }, new ContextMapper()
        {
            public Object mapFromContext(Object ctx) throws NamingException {
                DirContextAdapter context = (DirContextAdapter)ctx;
                Attributes attrs = context.getAttributes();
                NamingEnumeration ids = attrs.getIDs();
                Map m = new HashMap();
                List<String[]> list = new ArrayList();
                try {
                    while (ids.hasMore()) {
                        String id = (String)ids.next();

                        list.add(context.getStringAttributes(id));
                    }
                    if (list.size()>0) {
                        m.put(opAttr, list.get(0));
                    }
                } catch (NamingException e) {
                    e.printStackTrace();
                }
                return m;
            }
        });
    }

    protected DistinguishedName buildDn(WlsLdapUser user) {
        return buildDn(user.getUid());
    }

    public DistinguishedName buildDn(String uid) {
        DistinguishedName dn = new DistinguishedName();
        dn.add("ou", "people");
        dn.add("cn", uid);
        return dn;
    }

    protected DistinguishedName buildDnGroup(String cn)
    {
        DistinguishedName dn = new DistinguishedName();
        dn.add("ou", "groups");
        dn.add("cn", cn);
        return dn;
    }

    public void addToGroup(String dn, String gid) {
        DistinguishedName gdn = buildDnGroup(gid);

        addAttr(gdn, "uniquemember", dn);
    }



    public WlsLdapUser find(String uid) {
        List<WlsLdapUser> user = new ArrayList<>();

        //user.add(new WlsLdapUser());
        Object x;
        try {
           // user = (List<WlsLdapUser)getLdapTemplate().searchForObject("ou=people", new EqualsFilter("uid", uid).toString(), new WlsUserContextMapper());
           x = ldapTemplate
                    .search(
                            "ou=people",
                            "cn=" + uid,
                            (AttributesMapper<String>) attrs -> (String) attrs.get("cn").get());
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
        return user.get(0);
    }

    public List<String> getUserGroups(WlsLdapUser user) {
        Map<String, String[]> groupMmap = null;
        String[] groupMapArray = null ;
        ArrayList<String> results = new ArrayList<String>();
        groupMmap = this.getAttrsStartsWith(user.getDn(), "wlsMemberOf");
        if (!groupMmap.isEmpty()) {
            groupMapArray = groupMmap.get("wlsMemberOf");
            if (groupMapArray.length > 0) {
                for (int i = 0; i < groupMapArray.length; i++) {
                    String[] allGroups = StringUtils.split(groupMapArray[i], ",");
                    for (String s : allGroups) {
                        if (StringUtils.contains(s, "cn=")) {
                            String aGroup = StringUtils.remove(s, "cn=");
                            results.add(aGroup);
                            results.remove("Admin");
                        }
                    }
                }
            }
        }
        return results;
    }

    public WlsLdapUser update(WlsLdapUser user){
        //userLDAPRepository.delete(user);
      // create(user);
        userLDAPRepository.save(user);
        return user;
    }

    public WlsLdapUser updateRoles(WlsLdapUser user)
    {
        Name n = user.getDn();

        List<String> roles = getUserGroups(user);


        DirContextOperations context = ldapTemplate.lookupContext(n);
        roles.forEach(s -> {
            context.removeAttributeValue("wlsMemberOf","cn="+s+",ou=groups,ou=myrealm,dc="+domain+"");
        });

        context.addAttributeValue("wlsMemberOf","cn=Admin,ou=groups,ou=myrealm,dc="+domain+"");

        if (user.getGroups()!=null){
            for (int i = 0; i < user.getGroups().size() ; i++) {
                context.addAttributeValue("wlsMemberOf","cn="+user.getGroups().get(i)+",ou=groups,ou=myrealm,dc="+domain+"");
            }
        }

        ldapTemplate.modifyAttributes(context);

        return user;
    }

    public WlsLdapUser deleteRoles(WlsLdapUser user,String roleName)
    {
        Name n = user.getDn();

        DirContextOperations context = ldapTemplate.lookupContext(n);
        context.removeAttributeValue("wlsMemberOf","cn="+roleName+",ou=groups,ou=myrealm,dc="+domain+"");

        ldapTemplate.modifyAttributes(context);

        return user;
    }



    private Name buildPeopleDn(String groupName) {
        return LdapNameBuilder.newInstance("ou=people")
                .add(groupName).build();
    }



    public WlsLdapUser create(WlsLdapUser user)
    {
        Name dn = buildDn(user);
        DirContextAdapter context = new DirContextAdapter(dn);
        context.setAttributeValues("objectclass", new String[] { "top", "person", "inetOrgPerson", "organizationalPerson", "wlsuser" });

        context.setAttributeValue("uid", user.getUid());
        context.addAttributeValue("userpassword", user.getPassword());
        context.setAttributeValue("sn", user.getUid());
        context.setAttributeValue("cn", user.getUid());
        context.addAttributeValue("st", user.getAdddate());

        context.addAttributeValue("description", user.getFirstName());
        context.setAttributeValue("secretary", user.getSurName());
        context.setAttributeValue("pager", user.getPaterName());

        context.setAttributeValue("mail", user.getUsermail());
        context.addAttributeValue("homePhone", user.getTelephoneNumber());
        context.addAttributeValue("telephoneNumber", user.getMobphone());

        context.addAttributeValue("postOfficeBox", user.getBirthdate());
        context.addAttributeValue("departmentNumber", user.getDept());
        context.addAttributeValue("employeeType", user.getJob());

        context.addAttributeValue("manager", user.getIsCurator());
        context.addAttributeValue("seeAlso", user.getIsblocked());
        context.addAttributeValue("initials", user.getRoles());
        context.addAttributeValue("wlsMemberOf","cn=Admin,ou=groups,ou=myrealm,dc="+domain+"");

        if (user.getGroups()!=null){
            for (int i = 0; i < user.getGroups().size() ; i++) {
                context.addAttributeValue("wlsMemberOf","cn="+user.getGroups().get(i)+",ou=groups,ou=myrealm,dc="+domain+"");
            }
        }


        getLdapTemplate().bind(dn, context, null);
        return user;
    }


    private static  class WlsUserContextMapper extends AbstractContextMapper
    {
        protected Object doMapFromContext(DirContextOperations context)
        {
            WlsLdapUser user = new WlsLdapUser();
            user.setUid(context.getStringAttribute("uid"));
            return user;
        }
    }
}


