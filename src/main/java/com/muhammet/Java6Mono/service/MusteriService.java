package com.muhammet.Java6Mono.service;
import com.muhammet.Java6Mono.dto.request.MusteriSaveRequestDto;
import com.muhammet.Java6Mono.dto.response.MusteriFindAllResponseDto;
import com.muhammet.Java6Mono.excepiton.SatisManagerException;
import com.muhammet.Java6Mono.mapper.IMusteriMapper;
import com.muhammet.Java6Mono.repository.IMusteriRepository;
import com.muhammet.Java6Mono.repository.entity.Musteri;
import com.muhammet.Java6Mono.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MusteriService extends ServiceManager<Musteri,Long> {
  private final IMusteriRepository repository;
  public MusteriService(IMusteriRepository repository){
      super(repository);
      this.repository=repository;
  }
  public Musteri findByAd(String ad) {
    return repository.findByAd(ad);
  }

  public void saveDto(MusteriSaveRequestDto dto){
//      Musteri musteri = Musteri.builder()
//              .ad(dto.getAd())
//              .adres(dto.getAdres())
//              .telefon(dto.getTelefon())
//              .build();
//      save(musteri);
      save(IMusteriMapper.INSTANCE.bakSenOlusturDtoDanMusteri(dto));
  }

  public List<MusteriFindAllResponseDto> findAllResponseDtos(){
      List<MusteriFindAllResponseDto> result = new ArrayList<>();
      findAll().forEach(x->{
//          result.add(MusteriFindAllResponseDto.builder()
//                          .ad(x.getAd())
//                          .username(x.getUsername())
//                          .img(x.getImg())
//                  .build());
          result.add(IMusteriMapper.INSTANCE.formMusteri(x));
      });
      return result;
  }

  public Boolean doLogin(String username,String password){
     Optional<Musteri> musteri = repository.findOptionalByUsernameAndPassword(username, password);
     if(musteri.isEmpty()) return false;
     return true;
  }

}
