package com.muhammet.Java6Mono.service;

import com.muhammet.Java6Mono.dto.request.UrunSaveRequestDto;
import com.muhammet.Java6Mono.mapper.IUrunMapper;
import com.muhammet.Java6Mono.repository.IUrunRepository;
import com.muhammet.Java6Mono.repository.entity.Urun;
import com.muhammet.Java6Mono.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class UrunService extends ServiceManager<Urun,Long> {
    private final IUrunRepository repository;
    public UrunService(IUrunRepository repository){
        super(repository);
        this.repository=repository;
    }
    public void saveDto(UrunSaveRequestDto dto){
        save(IUrunMapper.INSTANCE.toUrun(dto));
    }
}
