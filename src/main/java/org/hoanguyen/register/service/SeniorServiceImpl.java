package org.hoanguyen.register.service;

import org.hoanguyen.register.dto.SeniorDTO;
import org.hoanguyen.register.entity.Senior;
import org.hoanguyen.register.exception.UserExistException;
import org.hoanguyen.register.repository.SeniorRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SeniorServiceImpl implements SeniorService{
    private SeniorRepository seniorRepository;

    public SeniorServiceImpl(SeniorRepository seniorRepository) {
        this.seniorRepository = seniorRepository;
    }

    @Autowired

    @Override
    public void saveSenior(SeniorDTO seniorDTO) throws UserExistException {
        Optional<Senior> optionalSenior = seniorRepository.findSeniorByEmail(seniorDTO.getEmail());
        if (optionalSenior.isEmpty()){
            ModelMapper modelMapper = new ModelMapper();
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
            Senior senior = modelMapper.map(seniorDTO, Senior.class);
            seniorRepository.save(senior);
        }
        else throw new UserExistException("Senior already exist");

    }

    @Override
    public SeniorDTO findSeniorByEmail(String email) {
        Optional<Senior>seniorOptional = seniorRepository.findSeniorByEmail(email);
        if(seniorOptional.isPresent()){
            ModelMapper modelMapper = new ModelMapper();
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
            SeniorDTO seniorDTO = modelMapper.map(seniorOptional.get(), SeniorDTO.class);
            return seniorDTO;
        }
        else
            throw new UsernameNotFoundException("User Not Found");
    }

    @Override
    public List<SeniorDTO> getAllSeniors() {
        List<SeniorDTO> seniorDTOS = new ArrayList<>();

        for(Senior senior : seniorRepository.findAll())
        {
            ModelMapper modelMapper = new ModelMapper();
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
            SeniorDTO seniorDTO = modelMapper.map(senior, SeniorDTO.class);

            seniorDTOS.add(seniorDTO);
        }
        return seniorDTOS;
    }
}
