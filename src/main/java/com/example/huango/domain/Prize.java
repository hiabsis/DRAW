package com.example.huango.domain;

import javax.persistence.*;

/**
 * @Author:陈义武
 * @Create: 2022-11-03 09:51
 * @Description: 轮盘抽奖的奖品
 */
@Entity
@Table(name = "prize")
public class Prize {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 自增长策略
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, optional = false)
    @JoinColumn(name = "activity_id")
    private Activity activity;
}
