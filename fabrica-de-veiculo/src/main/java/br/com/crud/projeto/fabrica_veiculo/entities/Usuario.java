package br.com.crud.projeto.fabrica_veiculo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

/**
 * Representa um usuário no sistema.
 */
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idusuario;

    private String nome;

    private String email;

    private String senha;

    private String perfil;

    /**
     * Construtor padrão.
     */
    public Usuario() {
    }

    /**
     * Construtor com todos os campos.
     *
     * @param idusuario o ID do usuário.
     * @param nome      o nome do usuário.
     * @param email     o email do usuário.
     * @param senha     a senha do usuário.
     * @param perfil    o perfil do usuário.
     */
    public Usuario(Long idusuario, String nome, String email, String senha, String perfil) {
        this.idusuario = idusuario;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.perfil = perfil;
    }

    /**
     * Obtém o ID do usuário.
     *
     * @return o ID do usuário.
     */
    public Long getIdusuario() {
        return idusuario;
    }

    /**
     * Define o ID do usuário.
     *
     * @param idusuario o ID do usuário.
     */
    public void setIdusuario(Long idusuario) {
        this.idusuario = idusuario;
    }

    /**
     * Obtém o nome do usuário.
     *
     * @return o nome do usuário.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do usuário.
     *
     * @param nome o nome do usuário.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém o email do usuário.
     *
     * @return o email do usuário.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Define o email do usuário.
     *
     * @param email o email do usuário.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtém a senha do usuário.
     *
     * @return a senha do usuário.
     */
    public String getSenha() {
        return senha;
    }

    /**
     * Define a senha do usuário.
     *
     * @param senha a senha do usuário.
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * Obtém o perfil do usuário.
     *
     * @return o perfil do usuário.
     */
    public String getPerfil() {
        return perfil;
    }

    /**
     * Define o perfil do usuário.
     *
     * @param perfil o perfil do usuário.
     */
    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    /**
     * Verifica se dois objetos Usuario são iguais.
     *
     * @param o o objeto a ser comparado.
     * @return true se os objetos forem iguais, false caso contrário.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(idusuario, usuario.idusuario) &&
                Objects.equals(nome, usuario.nome) &&
                Objects.equals(email, usuario.email) &&
                Objects.equals(senha, usuario.senha) &&
                Objects.equals(perfil, usuario.perfil);
    }

    /**
     * Calcula o código hash do objeto Usuario.
     *
     * @return o código hash do objeto.
     */
    @Override
    public int hashCode() {
        return Objects.hash(idusuario, nome, email, senha, perfil);
    }

    /**
     * Retorna uma representação em string do objeto Usuario.
     *
     * @return a representação em string do objeto.
     */
    @Override
    public String toString() {
        return "Usuario{" +
                "idusuario=" + idusuario +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", perfil='" + perfil + '\'' +
                '}';
    }
}
