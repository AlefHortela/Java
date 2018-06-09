package br.cubas.usercontrol.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.cubas.usercontrol.beans.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {

}
