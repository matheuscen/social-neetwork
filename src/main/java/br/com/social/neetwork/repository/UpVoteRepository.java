package br.com.social.neetwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.social.neetwork.entity.UpVoteEntity;
import br.com.social.neetwork.entity.UpVoteEntityPK;

@Repository
public interface UpVoteRepository extends JpaRepository<UpVoteEntity, UpVoteEntityPK> {

}
