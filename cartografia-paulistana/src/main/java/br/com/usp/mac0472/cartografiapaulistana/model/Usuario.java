package br.com.usp.mac0472.cartografiapaulistana.model;

import static jakarta.persistence.EnumType.STRING;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.usp.mac0472.cartografiapaulistana.dto.usuario.UserCreateDto;
import br.com.usp.mac0472.cartografiapaulistana.dto.usuario.UsuarioUpdateDto;
import br.com.usp.mac0472.cartografiapaulistana.enums.UsuarioRole;
import io.micrometer.common.util.StringUtils;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "USUARIO")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario implements UserDetails {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "login", nullable = false, length = 25)
	private String login;

	@Column(name = "senha", nullable = false, length = 200)
	private String senha;

	@Column(name = "numero_usp", nullable = false, length = 11)
	private String numeroUsp;
	
	@Column(name = "email", nullable = false, length = 45)
	private String email;

	@Column(name = "role", nullable = false)
	@Enumerated(STRING)
	private UsuarioRole role;

	public Usuario(UserCreateDto data, String senha) {
		this.login = data.login();
		this.senha = senha;
		this.numeroUsp = data.numeroUsp();
		this.email = data.email();
		this.role = UsuarioRole.valueOf(data.autorizacao().toUpperCase());
	}
	
	public void update(UsuarioUpdateDto updatedUsuario) {
		if(StringUtils.isNotBlank(updatedUsuario.login())){
			this.login = updatedUsuario.login();
		}
		if(StringUtils.isNotBlank(updatedUsuario.senha())){
			this.login = updatedUsuario.senha();
		}
		if(StringUtils.isNotBlank(updatedUsuario.numeroUsp())){
			this.login = updatedUsuario.numeroUsp();
		}
		if(StringUtils.isNotBlank(updatedUsuario.email())){
			this.login = updatedUsuario.email();
		}
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if (this.role == UsuarioRole.ADMIN) {
			return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
		}
		return List.of(new SimpleGrantedAuthority("ROLE_USER"));
	}

	@Override
	public String getPassword() {
		return this.getSenha();
	}

	@Override
	public String getUsername() {
		return this.getLogin();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
