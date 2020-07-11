package com.cha.edu.shiftenquiryservice.repository;


import com.cha.edu.shiftenquiryservice.entity.ShiftGrouping;
import org.springframework.data.repository.CrudRepository;

/**
 * JPA repository for ShiftGrouping entity
 */
public interface ShiftGroupingRepository extends CrudRepository<ShiftGrouping, Long> {

    /**
     * Derived query method to check whether shiftCode and shiftGroupCode is exists or not
     *
     * @param shiftCode
     * @param shiftGroupCode
     * @return is shiftCode and ShiftGroupCode is exists
     */
    Boolean existsByShiftCodeAndShiftGroupCode(String shiftCode, String shiftGroupCode);

}
