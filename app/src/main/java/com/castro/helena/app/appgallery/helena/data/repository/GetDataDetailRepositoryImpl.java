package com.castro.helena.app.appgallery.helena.data.repository;

import com.castro.helena.app.appgallery.helena.data.remote.dto.DataAggDto;
import com.castro.helena.app.appgallery.helena.data.remote.dto.DataDetailDto;
import com.castro.helena.app.appgallery.helena.domain.repository.GetDataDetailRepository;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Observable;

public class GetDataDetailRepositoryImpl implements GetDataDetailRepository {

    @Inject
    public GetDataDetailRepositoryImpl() {
    }

    @Override
    public Observable<DataDetailDto> getImageDetail(DataAggDto dataAggDto) {
        // TODO get array of Image(s);
//        List<Image> images = new ArrayList<>();
//        if (dataAggDto.getDataAgg() != null && dataAggDto.getDataAgg().size() > 0) {
//            for (DataDetail dataDetail : dataAggDto.getDataAgg()) {
//                if (dataDetail.getImages() != null && dataDetail.getImages().size() > 0) {
//                    images.addAll(dataDetail.getImages());
//                }
//           }
//        }
//        return null;

        return null;
    }

}
