package com.api.compras.services.compras.;

import com.api.compras.beans.CompraBean;
import com.api.compras.dao.CompraDao;
import com.api.compras.dto.CompraDTO;
import com.api.compras.interfaces.IBean;
import com.api.compras.interfaces.IDto;
import com.api.compras.utils.Setting;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CompraServiceImpl implements IComprasService{

    @Autowired
    private  CompraDao compraDao;
    @Autowired
    private ModelMapper modelMapper;
    public CompraServiceImpl(CompraDao compraDao, ModelMapper modelMapper){
        this.compraDao = compraDao;
        this.modelMapper = modelMapper;
    }


    @Override
    @Transactional
    public CompraDTO create(CompraDTO compraDTO) {
        CompraBean compra = toBean(compraDTO);
        compra = compraDao.save(compra);

        return toDTO(compra);
    }

    @Override
    @Transactional
    public CompraDTO getById(Long id) {
        Optional<CompraBean> compraBean = compraDao.findById(id);
        if(compraBean != null){
            return compraBean.map(this::toDTO).orElse(null);
        }else {
            return null;
        }
    }

    @Override
    @Transactional
    public List<CompraDTO> getAll(int page) {
        Pageable pageable = PageRequest.of(page, Setting.PAGE_SIZE);
        Page<CompraBean> compraBeanPage = compraDao.findAllByIsActivoTrue(pageable);
        return compraBeanPage.getContent().stream().map(this::toDTO).collect(Collectors.toList());
    }
    public CompraBean toBean(IDto compraDto){
        return modelMapper.map(compraDto, CompraBean.class);
    }

    public CompraDTO toDTO(IBean compraBean) {
        return modelMapper.map(compraBean, CompraDTO.class);
    }
}
