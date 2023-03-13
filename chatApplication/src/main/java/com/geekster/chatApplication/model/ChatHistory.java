package com.geekster.chatApplication.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_chat_history")
public class ChatHistory {

    @Id
    @Column(name = "chat_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int chatId;

    @JoinColumn(name = "to_user_id")
    @ManyToOne
    private Users to;


    @JoinColumn(name = "from_user_id")
    @ManyToOne
    private  Users from;


     @Column(name = "message")
    private  String message;

    @Column(name = "created_date")
    private Timestamp createDate;

    @Column(name = "updated_date")
    private  Timestamp updateDate;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status statusId;



}
