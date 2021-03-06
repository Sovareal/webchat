package com.infopulse.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name="messages")
public class Message {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Basic
    private Long id;

    @Column(name="body", nullable = false)
    private String body;

    @ManyToOne
    @JoinColumn(name = "sender_id",
            foreignKey = @ForeignKey(name = "SENDER_ID_FK")
    )
    private ChatUser sender;

    @ManyToOne
    @JoinColumn(name = "receiver_id",
            foreignKey = @ForeignKey(name = "RECEIVER_ID_FK")
    )
    private ChatUser receiver;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="create_time")
    private Date createTime;
}
