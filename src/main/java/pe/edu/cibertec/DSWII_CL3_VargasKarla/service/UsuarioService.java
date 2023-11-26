package pe.edu.cibertec.DSWII_CL3_VargasKarla.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.DSWII_CL3_VargasKarla.model.bd.Usuario;
import pe.edu.cibertec.DSWII_CL3_VargasKarla.repository.UsuarioRepository;

@AllArgsConstructor
@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public Usuario findByNomusuario(String usuario){
        return usuarioRepository.findByNomusuario(usuario);
    }


}
