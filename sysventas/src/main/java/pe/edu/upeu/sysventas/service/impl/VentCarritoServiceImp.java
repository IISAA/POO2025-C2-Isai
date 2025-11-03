package pe.edu.upeu.sysventas.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upeu.sysventas.model.VentCarrito;
import pe.edu.upeu.sysventas.repository.ICrudGenericoRepository;
import pe.edu.upeu.sysventas.repository.VentCarritoRepository;
import pe.edu.upeu.sysventas.service.IVentaCarritoService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class VentCarritoServiceImp extends CrudGenericoServiceImp<VentCarrito, Long> implements IVentaCarritoService {
    private final VentCarritoRepository ventCarritoRepository;

    @Override
    protected ICrudGenericoRepository<VentCarrito, Long> getRepo() {
        return ventCarritoRepository;
    }

    @Override
    public List<VentCarrito> listaCarritoCliente(String dni) {
        return ventCarritoRepository.listaCarritoCliente(dni);
    }
    @Transactional
    @Override
    public void deleteCarAll(String dniruc) {
        ventCarritoRepository.deleteByDniruc(dniruc);
    }

    @Override
    public VentCarrito update(VentCarrito entity) {
        return null;
    }
}
