package org.hoanguyen.register.service;

import org.hoanguyen.register.dto.SeniorDTO;
import org.hoanguyen.register.exception.UserExistException;

import java.util.List;

public interface SeniorService {
    public void saveSenior(SeniorDTO seniorDTO) throws UserExistException;
    public SeniorDTO findSeniorByEmail ( String email);

    public List<SeniorDTO> getAllSeniors();

}