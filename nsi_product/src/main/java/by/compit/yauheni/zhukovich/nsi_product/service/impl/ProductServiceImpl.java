package by.compit.yauheni.zhukovich.nsi_product.service.impl;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import by.compit.yauheni.zhukovich.nsi_product.repository.CardRepository;
import by.compit.yauheni.zhukovich.nsi_product.repository.CreditRepository;
import by.compit.yauheni.zhukovich.nsi_product.repository.DebitRepository;
import by.compit.yauheni.zhukovich.nsi_product.repository.ListRepository;
import by.compit.yauheni.zhukovich.nsi_product.repository.ProductRepository;
import by.compit.yauheni.zhukovich.nsi_product.repository.UrCredRepository;
import by.compit.yauheni.zhukovich.nsi_product.repository.UrDepRepository;
import by.compit.yauheni.zhukovich.nsi_product.repository.model.ctl.Card;
import by.compit.yauheni.zhukovich.nsi_product.repository.model.ctl.Credit;
import by.compit.yauheni.zhukovich.nsi_product.repository.model.ctl.Debit;
import by.compit.yauheni.zhukovich.nsi_product.repository.model.ctl.Product;
import by.compit.yauheni.zhukovich.nsi_product.repository.model.ctl.ProductGroup;
import by.compit.yauheni.zhukovich.nsi_product.repository.model.nsi.UrCred;
import by.compit.yauheni.zhukovich.nsi_product.repository.model.nsi.UrDep;
import by.compit.yauheni.zhukovich.nsi_product.service.ProductService;
import by.compit.yauheni.zhukovich.nsi_product.service.exception.NonexistentProductException;
import by.compit.yauheni.zhukovich.nsi_product.service.exception.NullEntityException;
import by.compit.yauheni.zhukovich.nsi_product.service.model.ProductAggregation;

import static by.compit.yauheni.zhukovich.nsi_product.service.util.CheckUtil.checkProductForNotNull;

@Service
public class ProductServiceImpl implements ProductService {

    private final CreditRepository creditRepository;
    private final DebitRepository debitRepository;
    private final CardRepository cardRepository;
    private final UrDepRepository urDepRepository;
    private final UrCredRepository urCredRepository;
    private final ProductRepository productRepository;
    private final ListRepository listRepository;

    public ProductServiceImpl(
            DebitRepository debitRepository,
            CardRepository cardRepository,
            UrDepRepository urDepRepository,
            CreditRepository creditRepository,
            UrCredRepository urCredRepository,
            ProductRepository productRepository, ListRepository listRepository) {
        this.debitRepository = debitRepository;
        this.cardRepository = cardRepository;
        this.urDepRepository = urDepRepository;
        this.creditRepository = creditRepository;
        this.urCredRepository = urCredRepository;
        this.productRepository = productRepository;
        this.listRepository = listRepository;
    }

    @Override
    public ProductAggregation getAll() {
        ProductAggregation productAggregation = new ProductAggregation();
        setUrProductAggregation(productAggregation);
        setPhProductAggregation(productAggregation);
        return productAggregation;
    }

    @Override
    public Object getById(Long id) throws NonexistentProductException {
        Product product = getProduct(id);
        checkProductForNotNull(product);
        Long productId = product.getProductId();
        ProductGroup productGroup = product.getProductGroup();
        String tableName = null;
        if (productGroup != null) {
            tableName = productGroup.getTableName();
        }
        if (productId != null && tableName != null) {
            switch (tableName) {
                case "NSI.URCRED":
                    return getUrCredById(productId);
                case "CREDIT":
                    return getCreditById(productId);
                case "NSI.URDEP":
                    return getUrDepById(productId);
                case "DEBIT":
                    return getDebitById(productId);
                case "CARD":
                    return getCardById(productId);
                default:
                    throw new UnsupportedOperationException("Unsupported table name.");
            }
        }
        return null;
    }

    @Transactional
    public UrCred getUrCredById(Long productId) {
        return urCredRepository.getById(productId);
    }

    @Transactional
    public UrDep getUrDepById(Long productId) {
        return urDepRepository.getById(productId);
    }

    @Transactional
    public Card getCardById(Long productId) {
        return cardRepository.getById(productId);
    }

    @Transactional
    public Credit getCreditById(Long productId) {
        return creditRepository.getById(productId);
    }

    @Transactional
    public Debit getDebitById(Long productId) {
        return debitRepository.getById(productId);
    }

    @Transactional
    public Product getProduct(Long id) {
        return productRepository.getById(id);
    }

    @Override
    @Transactional
    public ProductAggregation getByContraAgentType(String contrAgentType) {
        ProductAggregation productAggregation = new ProductAggregation();
        switch (contrAgentType) {
            case "le":
                setUrProductAggregation(productAggregation);
                return productAggregation;
            case "ph":
                setPhProductAggregation(productAggregation);
                return productAggregation;
            default:
                throw new UnsupportedOperationException("Unsupported contr agent type.");
        }
    }

    @Override
    @Transactional
    public ProductAggregation getByProductClass(String productClass) {
        ProductAggregation productAggregation = new ProductAggregation();
        List<Debit> debits = debitRepository.getByProductClass(productClass);
        productAggregation.setDebits(debits);
        return productAggregation;
    }

    @Override
    @Transactional
    public ProductAggregation getByProductType(String productType) {
        ProductAggregation productAggregation = new ProductAggregation();
        List<Debit> debits = debitRepository.getByProductType(productType);
        productAggregation.setDebits(debits);
        return productAggregation;
    }

    @Override
    public ProductAggregation getByProductName(String productName) {
        ProductAggregation productAggregation = new ProductAggregation();
        List<Debit> debits = debitRepository.getByProductName(productName);
        productAggregation.setDebits(debits);
        List<Credit> credits = creditRepository.getByProductName(productName);
        productAggregation.setCredits(credits);
        List<Card> cards = cardRepository.getByProductName(productName);
        productAggregation.setCards(cards);
        List<UrCred> urCreds = urCredRepository.getByProductName(productName);
        productAggregation.setUrCreds(urCreds);
        List<UrDep> urDeps = urDepRepository.getByProductName(productName);
        productAggregation.setUrDeps(urDeps);
        return productAggregation;
    }

    @Override
    public List<Long> getIdsByBPCardId(String id) throws NullEntityException {
        Long productHierarchyId = getProductHierarchyByBPCardId(id);
        return getByHierarchy(productHierarchyId);
    }

    @Transactional
    public List<Long> getByHierarchy(Long productHierarchyId) {
        return productRepository.getByHierarchy(productHierarchyId);
    }

    @Transactional
    public Long getProductHierarchyByBPCardId(String id) throws NullEntityException {
        return listRepository.getProductHierarchyByBPCardId(id);
    }

    @Transactional
    public void setPhProductAggregation(ProductAggregation productAggregation) {
        List<Credit> credits = creditRepository.getAll();
        productAggregation.setCredits(credits);
        List<Debit> debits = debitRepository.getAll();
        productAggregation.setDebits(debits);
        List<Card> cards = cardRepository.getAll();
        productAggregation.setCards(cards);
    }

    @Transactional
    public void setUrProductAggregation(ProductAggregation productAggregation) {
        List<UrDep> urDeps = urDepRepository.getAll();
        productAggregation.setUrDeps(urDeps);
        List<UrCred> urCreds = urCredRepository.getAll();
        productAggregation.setUrCreds(urCreds);
    }

}
