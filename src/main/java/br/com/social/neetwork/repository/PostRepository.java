package br.com.social.neetwork.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.social.neetwork.entity.PostEntity;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {
	
	
	@Query(value="SELECT post.id, post.post , user.social_name , "
			+ "(SELECT count(*) FROM UPVOTE up where up.post_id = post.id) as upvote , "
			+ "(SELECT count(*) FROM UPVOTE up where up.post_id = post.id and up.username = :username) as upvoted "
			+ "FROM POST post inner join USER user on post.user_id = user.id "
			+ "ORDER BY post.id DESC",
			countQuery = "SELECT count(p.id) FROM POST p",
			nativeQuery = true)
	public Page<Object[]> findAllPageable(Pageable pg, @Param("username") String username);

}
