package com.castro.helena.app.appgallery.helena.data.source.repository;

import com.castro.helena.app.appgallery.helena.data.source.remote.dto.DataAggDto;
import com.castro.helena.app.appgallery.helena.domain.model.DataDetail;
import com.castro.helena.app.appgallery.helena.domain.model.Image;
import com.castro.helena.app.appgallery.helena.domain.repository.GetDataDetailRepository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;


public class GetDataDetailRepositoryImpl implements GetDataDetailRepository {

    @Inject
    public GetDataDetailRepositoryImpl() {
    }

    @Override
    public DataDetail getImageDetail(DataAggDto dataAggDto) {
        // TODO get array of Image(s);
//        List<Image> images = new ArrayList<>();
//        if (dataAggDto.getDataAgg() != null && dataAggDto.getDataAgg().size() > 0) {
//            for (DataDetail dataDetail : dataAggDto.getDataAgg()) {
//                if (dataDetail.getImages() != null && dataDetail.getImages().size() > 0) {
//                    images.addAll(dataDetail.getImages());
//                }
//           }
//        }
//        return images;
        return null;
    }

}
