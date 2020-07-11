package com.cha.edu.shiftenquiryservice.service;

/**
 * Interface to implement business logic related to shift grouping
 */
public interface ShiftGroupingService {
    /**
     * This method checks whether shiftCode and shiftGroupCode is exists or not
     *
     * @param shiftCode
     * @param shiftGroupCode
     * @return is shiftCode and ShiftGroupCode is exists
     */
    boolean doesShiftBelongToGroup(String shiftCode, String shiftGroupCode);
}
