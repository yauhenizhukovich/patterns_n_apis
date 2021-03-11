package by.compit.yauheni.zhukovich.business_initiative.service.util.conversion.business_initiative;

import org.example.TBIInfoSystemInfluence;

import by.compit.yauheni.zhukovich.business_initiative.repository.model.business_initiative.InfoSystemInfluence;

public class InfoSystemInfluenceConversionUtil {

    public static InfoSystemInfluence convertDTOToDatabaseObject(TBIInfoSystemInfluence infoSystemInfluenceDTO) {
        InfoSystemInfluence infoSystemInfluence = new InfoSystemInfluence();
        if (infoSystemInfluenceDTO.getInfluencedescription() != null) {
            infoSystemInfluence.setInfluenceDescription(infoSystemInfluenceDTO.getInfluencedescription());
        }
        if (infoSystemInfluenceDTO.getInfoSystemInfluence() != null) {
            infoSystemInfluence.setInfoSystemInfluence(infoSystemInfluenceDTO.getInfoSystemInfluence());
        }
        return infoSystemInfluence;
    }

    public static TBIInfoSystemInfluence convertDatabaseObjectToDTO(InfoSystemInfluence infoSystemInfluence) {
        TBIInfoSystemInfluence infoSystemInfluenceDTO = new TBIInfoSystemInfluence();
        if (infoSystemInfluence.getInfluenceDescription() != null) {
            infoSystemInfluenceDTO.setInfluencedescription(infoSystemInfluence.getInfluenceDescription());
        }
        if (infoSystemInfluence.getInfoSystemInfluence() != null) {
            infoSystemInfluenceDTO.setInfoSystemInfluence(infoSystemInfluence.getInfoSystemInfluence());
        }
        return infoSystemInfluenceDTO;
    }

}
