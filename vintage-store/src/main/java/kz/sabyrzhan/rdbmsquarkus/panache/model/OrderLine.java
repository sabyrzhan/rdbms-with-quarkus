package kz.sabyrzhan.rdbmsquarkus.panache.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "t_order_lines")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OrderLine extends PanacheEntity {
    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @Column
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "purchase_order_id")
    private PurchaseOrder purchaseOrder;
}
