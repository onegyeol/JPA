package jpabook.jpashop.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "DELIVERY")
public class Delivery extends BaseEntity{

    @Id @GeneratedValue
    @Column(name = "DELIVERY_ID")
    private Long id;

    @OneToOne(mappedBy = "delivery")
    private Order order;

    private String city;

    private String street;
    private String zipcode;

    private DeliveryStatus status;

}
