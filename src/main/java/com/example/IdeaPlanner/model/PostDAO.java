package com.example.IdeaPlanner.model;

import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class PostDAO {

    @Autowired
    DataSource dataSource;

    JdbcTemplate jdbc;

    @PostConstruct
    private void initialize() {
        jdbc = new JdbcTemplate(dataSource);
    }

    public void inserirPost(Post post, String usuarioId) {
        String sql = "INSERT INTO posts (titulo, ideia, plataforma, status, data_prevista, usuario_id)" +
                     " VALUES (?,?,?,?,?,?::uuid)";
        Object[] obj = new Object[6];
        obj[0] = post.getTitulo();
        obj[1] = post.getIdeia();
        obj[2] = post.getPlataforma();
        obj[3] = post.getStatus();
        obj[4] = post.getDataPrevista();
        obj[5] = usuarioId;
        jdbc.update(sql, obj);
    }

    public Post mostrarPost(String uuid){
        String sql = "SELECT * FROM posts where id=?::uuid";
        return Post.converter(jdbc.queryForMap(sql,uuid));
	}

    public ArrayList<Post> listarPosts(String usuarioId){
		String sql = "SELECT * FROM posts WHERE usuario_id = ?::uuid";
		return Post.converterTodos(jdbc.queryForList(sql, usuarioId));
	}

    public void atualizarPost(Post post, String uuid){
		String sql = "UPDATE posts " + 
			"SET titulo = ?, ideia = ?, plataforma = ?, status = ?, data_prevista = ? WHERE id = ?::uuid";
        Object[] obj = new Object[6];
        obj[0] = post.getTitulo();
        obj[1] = post.getIdeia();
        obj[2] = post.getPlataforma();
        obj[3] = post.getStatus();
        obj[4] = post.getDataPrevista();
        obj[5] = uuid;
		jdbc.update(sql,obj);
	}

    public void deletarPost(String uuid){
		String sql = "Delete from posts WHERE id = ?::uuid";
        Object[] obj = new Object[1];
        obj[0] = uuid;
		jdbc.update(sql,obj);
	}
}
