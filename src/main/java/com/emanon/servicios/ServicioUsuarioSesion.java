package com.emanon.servicios;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.emanon.entidades.UsuarioRol;
import com.emanon.entidades.UsuarioSesion;
import com.emanon.repositorio.RepositorioUsuarioSesion;



@Service("servicioUsuarioSesion")
public class ServicioUsuarioSesion implements UserDetailsService{
	
	@Autowired
	@Qualifier("repositorioUsuarioSesion")
	private RepositorioUsuarioSesion repositorioUsuarioSesion;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UsuarioSesion usuarioSesion = repositorioUsuarioSesion.findByUsername(username);
		List<GrantedAuthority> authorities = buildAuthorities(usuarioSesion.getUsuarioRol());
		return buildUser(usuarioSesion, authorities);
	}
	
	private User buildUser(UsuarioSesion usuario, List<GrantedAuthority> authorities) {
		return new User(usuario.getUsername(), usuario.getClave(), usuario.isDisponible(),
				true, true, true, authorities);
				//accountNonExpired, credentialsNonExpired, accountNonLocked,
	}
	
	
	private List<GrantedAuthority> buildAuthorities(Set<UsuarioRol> usuarioRoles){
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		for (UsuarioRol usuarioRol : usuarioRoles) {
			authorities.add(new SimpleGrantedAuthority(usuarioRol.getRol()));
		}
		return new ArrayList<GrantedAuthority>(authorities);
	}
}
