package com.Agile.Library.repositories;

import com.Agile.Library.entities.BookIssue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookIssueRepository extends JpaRepository<BookIssue , Long> {

}
