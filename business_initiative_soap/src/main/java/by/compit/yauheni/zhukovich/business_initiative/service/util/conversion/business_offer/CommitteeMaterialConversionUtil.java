package by.compit.yauheni.zhukovich.business_initiative.service.util.conversion.business_offer;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.example.TBOCommiteeMaterials;

import by.compit.yauheni.zhukovich.business_initiative.repository.model.business_offer.CommitteeMaterial;

public class CommitteeMaterialConversionUtil {

    public static CommitteeMaterial convertDTOToDatabaseObject(TBOCommiteeMaterials committeeMaterialDTO) {
        CommitteeMaterial committeeMaterial = new CommitteeMaterial();
        JAXBElement<String> explanatoryNote = committeeMaterialDTO.getExplanatoryNote();
        if (explanatoryNote != null) {
            committeeMaterial.setExplanatoryNote(explanatoryNote.getValue());
        }
        JAXBElement<String> decisionProject = committeeMaterialDTO.getDecisionProject();
        if (decisionProject != null) {
            committeeMaterial.setDecisionProject(decisionProject.getValue());
        }
        return committeeMaterial;
    }

    public static TBOCommiteeMaterials convertDatabaseObjectToDTO(CommitteeMaterial committeeMaterial) {
        TBOCommiteeMaterials committeeMaterialDTO = new TBOCommiteeMaterials();
        String decisionProject = committeeMaterial.getDecisionProject();
        if (decisionProject != null) {
            JAXBElement<String> jaxbElement = new JAXBElement<>(
                    new QName("http://www.example.org", "decisionProject"), String.class, decisionProject);
            committeeMaterialDTO.setDecisionProject(jaxbElement);
        }
        String explanatoryNote = committeeMaterial.getExplanatoryNote();
        if (explanatoryNote != null) {
            JAXBElement<String> jaxbElement = new JAXBElement<>(
                    new QName("http://www.example.org", "explanatoryNote"), String.class, explanatoryNote);
            committeeMaterialDTO.setExplanatoryNote(jaxbElement);
        }
        return committeeMaterialDTO;
    }

}
