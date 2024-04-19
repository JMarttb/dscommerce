package com.devsup.dscommerce.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//Anotações de especificação do JPA
@Entity
//Customizar o nome da tabela
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //@Id é usada para marcar um campo em uma classe de entidade como a chave primária da tabela correspondente no banco de dados
    //@GeneratedValue(strategy = GenerationType.IDENTITY) é usada para indicar que o valor da chave primária será gerado automaticamente
    // private Long id; pelo banco de dados (normalmente usado com autoincremento ou identidade, dependendo do banco de dados).

    private String name;
    private String email;
    private String phone;
    // classe LocalDate para representar uma data sem informações de hora e fuso horário, atributo do Spring
    private LocalDate birtDate;
    private String password;

    @OneToMany(mappedBy = "client")
    private List<Order> orders = new ArrayList<>();
    //como a relação é de um para muitos, deve existir uma coleção, nesse caso, uma lista


    /*Criar dois construtores em uma classe é uma prática comum em Java, e tem a ver com a flexibilidade e reutilização de
    código. Vamos analisar os motivos para ter ambos os construtores:

    1. **Construtor Vazio**: O construtor vazio, sem argumentos, é útil em situações em que você precisa instanciar um objeto sem
    fornecer nenhum valor inicial para seus atributos. Isso é especialmente útil em cenários onde você pode precisar criar um objeto primeiro
    e, em seguida, preencher seus atributos posteriormente, talvez em etapas diferentes do código.

    2. **Construtor com Parâmetros**: O construtor com parâmetros permite criar um objeto e inicializar seus atributos ao mesmo tempo,
    passando os valores desejados como argumentos para o construtor. Isso é útil quando você já tem todos os dados necessários para inicializar o objeto no momento da criação.

    Ao fornecer ambos os construtores, você oferece flexibilidade no uso da classe `User`. Você pode escolher usar o construtor vazio e
    definir os atributos posteriormente, ou pode usar o construtor com parâmetros para definir os atributos no momento da criação do
    objeto. Isso permite que seu código seja mais flexível e adaptável a diferentes cenários de uso.
    */


    public User() {

    }

    public User(Long id, String name, String email, String phone, LocalDate birtDate, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.birtDate = birtDate;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getBirtDate() {
        return birtDate;
    }

    public void setBirtDate(LocalDate birtDate) {
        this.birtDate = birtDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Order> getOrders() {
        return orders;
    }
}
