package com.cha.edu.shiftenquiryservice.rest;

import com.cha.edu.shiftenquiryservice.ShiftEnquiryServiceApplication;
import com.cha.edu.shiftenquiryservice.exception.ShiftGroupingServiceException;
import com.cha.edu.shiftenquiryservice.service.ShiftGroupingService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = {ShiftEnquiryServiceApplication.class})
public class ShiftGroupingControllerTests {

    @MockBean
    private ShiftGroupingService shiftGroupingService;

    @InjectMocks
    private ShiftGroupingController shiftGroupingController;

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();

    }

    @Test
    public void shiftBelongToTheGroupShouldReturnTrueForValidGroup() throws Exception {
        when(shiftGroupingService.doesShiftBelongToGroup("shiftA", "groupX")).thenReturn(true);
        mockMvc.perform(get("/shift-grouping/group/groupX/shift/shiftA")).andExpect(status().isOk())
                .andExpect(content().string("true"));

    }

    @Test
    public void shiftBelongToTheGroupShouldReturnFalseForInValidGroup() throws Exception {
        when(shiftGroupingService.doesShiftBelongToGroup("shiftA", "groupX")).thenReturn(false);
        mockMvc.perform(get("/shift-grouping/group/groupX/shift/shiftA")).andExpect(status().isNotFound());

    }

    @Test
    public void shiftBelongToTheGroupServiceException() throws Exception {
        when(shiftGroupingService.doesShiftBelongToGroup("shiftA", "groupX")).thenThrow(new ShiftGroupingServiceException("test", new Exception()));
        mockMvc.perform(get("/shift-grouping/group/groupX/shift/shiftA")).andExpect(status().isInternalServerError());

    }

    @Test
    public void shiftBelongToTheGroupServiceValidationException() throws Exception {
        mockMvc.perform(get("/shift-grouping/group/a/shift/b")).andExpect(status().isBadRequest());

    }

}
