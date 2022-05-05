package dock.repository;

import dock.model.TerminalModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.demo.springboot.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<TerminalModel, Long>{

}