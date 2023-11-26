package pe.edu.cibertec.DSWII_CL3_VargasKarla.model.bd.sp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class UsuarioSp {
    @Id
    private Long idusuario;
    private String nomusuario;
}