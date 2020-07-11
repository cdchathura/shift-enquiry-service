package com.cha.edu.shiftenquiryservice.service.impl;

import com.cha.edu.shiftenquiryservice.exception.ShiftGroupingServiceException;
import com.cha.edu.shiftenquiryservice.repository.ShiftGroupingRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ShiftGroupingServiceImplTest {

    @Mock
    private ShiftGroupingRepository shiftGroupingRepository;

    @InjectMocks
    private ShiftGroupingServiceImpl shiftGroupingService;

    @Test
    public void existsByShiftCodeAndShiftGroupCodePassingTheArgToRepository() {
        when(shiftGroupingRepository.existsByShiftCodeAndShiftGroupCode("shift", "group")).thenReturn(false);
        assertFalse(shiftGroupingService.doesShiftBelongToGroup("shift", "group"));
        verify(shiftGroupingRepository).existsByShiftCodeAndShiftGroupCode("shift", "group");
    }


    @Test(expected = ShiftGroupingServiceException.class)
    public void existsByShiftCodeAndShiftGroupCodeException() {
        when(shiftGroupingRepository.existsByShiftCodeAndShiftGroupCode("shift", "group")).thenThrow(new RuntimeException());
        shiftGroupingService.doesShiftBelongToGroup("shift", "group");
    }

}
