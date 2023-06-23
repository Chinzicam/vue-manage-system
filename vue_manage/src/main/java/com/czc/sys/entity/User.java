package com.czc.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author czc
 * @since 2023-06-23
 */
@TableName("t_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private String username;

    private String password;

    private String money;

    private String thumb;

    private String address;

    private Integer status;

    private LocalDateTime date;

    private String deleted;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }
    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "User{" +
            "id=" + id +
            ", name=" + name +
            ", username=" + username +
            ", password=" + password +
            ", money=" + money +
            ", thumb=" + thumb +
            ", address=" + address +
            ", status=" + status +
            ", date=" + date +
            ", deleted=" + deleted +
        "}";
    }
}
