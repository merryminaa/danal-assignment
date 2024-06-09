package com.danal.prototype.job;

import com.danal.prototype.CommercialDistrictRepository;
import com.danal.prototype.domain.CommercialDistrict;
import com.danal.prototype.domain.CommercialDistrictDto;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class CsvScheduleWriter implements ItemWriter<CommercialDistrictDto> {

    private final CommercialDistrictRepository commercialDistrictRepository;

//    @Override
//    public void write(List<? extends CommercialDistrictDto> items) throws Exception {
//        List<CommercialDistrict> commercialDistricts = new ArrayList<>();
//
//        items.forEach(getCommercialDistrictDto -> {
//            CommercialDistrict commercialDistrict = getCommercialDistrictDto.toEntity();
//            commercialDistricts.add(commercialDistrict);
//        });
//
//        commercialDistrictRepository.saveAll(commercialDistricts);
//
//    }

    @Override
    public void write(Chunk<? extends CommercialDistrictDto> chunk) throws Exception {
        List<CommercialDistrict> commercialDistricts = new ArrayList<>();

        chunk.forEach(getCommercialDistrictDto -> {
            commercialDistricts.add(getCommercialDistrictDto.toEntity());
        });

        commercialDistrictRepository.saveAll(commercialDistricts);
    }
}
