package kz.sabyrzhan.rdbmsquarkus.panache.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import kz.sabyrzhan.rdbmsquarkus.jpa.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_purchase_orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class PurchaseOrder extends PanacheEntity {
    @Column
    private LocalDate purchaseDate = LocalDate.now();

    @OneToMany(mappedBy = "purchaseOrder")
    private List<OrderLine> orders = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column
    private Instant createdDate = Instant.now();

    public PurchaseOrder withOrderLine(OrderLine orderLine) {
        orders.add(orderLine);
        orderLine.setPurchaseOrder(this);
        return this;
    }
}
