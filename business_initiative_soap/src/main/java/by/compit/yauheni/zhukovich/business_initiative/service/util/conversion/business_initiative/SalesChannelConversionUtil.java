package by.compit.yauheni.zhukovich.business_initiative.service.util.conversion.business_initiative;

import org.example.TBISalesChannels;

import by.compit.yauheni.zhukovich.business_initiative.repository.model.business_initiative.SalesChannel;

public class SalesChannelConversionUtil {

    public static SalesChannel convertDTOToDatabaseObject(TBISalesChannels salesChannelDTO) {
        SalesChannel salesChannel = new SalesChannel();
        String salesChannels = salesChannelDTO.getSalesChannels();
        if (salesChannels != null) {
            salesChannel.setSalesChannel(salesChannels);
        }
        return salesChannel;
    }

    public static TBISalesChannels convertDatabaseObjectToDTO(SalesChannel salesChannel) {
        TBISalesChannels salesChannelDTO = new TBISalesChannels();
        if (salesChannel.getSalesChannel() != null) {
            salesChannelDTO.setSalesChannels(salesChannel.getSalesChannel());
        }
        return salesChannelDTO;
    }

}
