package com.cha.edu.shiftenquiryservice.service.impl;

import com.cha.edu.shiftenquiryservice.exception.ShiftGroupingServiceException;
import com.cha.edu.shiftenquiryservice.repository.ShiftGroupingRepository;
import com.cha.edu.shiftenquiryservice.service.ShiftGroupingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;


/**
 * Service impl for business logic related to shift grouping
 */
@Service
@EnableCaching
public class ShiftGroupingServiceImpl implements ShiftGroupingService {
    private static final Logger logger = LoggerFactory.getLogger(ShiftGroupingServiceImpl.class);

    @Autowired
    private ShiftGroupingRepository shiftGroupingRepository;

    @Override
    @Cacheable("shiftGrouping")
    public boolean doesShiftBelongToGroup(String shiftCode, String shiftGroupCode) {
        try {
            return shiftGroupingRepository.existsByShiftCodeAndShiftGroupCode(shiftCode, shiftGroupCode);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ShiftGroupingServiceException("Error enquiring using shift " + shiftCode + " group code  " + shiftGroupCode, e);
        }

    }


}
