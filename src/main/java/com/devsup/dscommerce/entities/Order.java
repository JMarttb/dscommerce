package com.devsup.dscommerce.entities;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "tb_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //a coluna armazenará valores de data e hora sem levar em consideração o fuso horário.
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant moment;
    private OrderStatus status;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;
    //@ManyToOne anotação que mapeia muitos para um
    //@JoinColumn(name = "client_id") adiciona uma coluna na tabela tb_order como chave estrageira fazendo referência a user
    //private User client; como a relação no diagrama é de pedido para um único usuário, ele deve ser implementado, respeitando o nome no diagrama

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }
}
