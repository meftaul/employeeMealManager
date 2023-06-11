package com.meftaul.emm.service.impl;

import com.meftaul.emm.entity.Vendor;
import com.meftaul.emm.service.EmmService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class VendorServiceImpl implements EmmService<Vendor, Long> {
    @Override
    public Vendor save(Vendor vendor) {
        return null;
    }

    @Override
    public Page<Vendor> getList(Pageable page) {
        return null;
    }

    @Override
    public Vendor getById(Long aLong) {
        return null;
    }

    @Override
    public Vendor update(Vendor vendor) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }
}
