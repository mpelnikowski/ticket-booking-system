package pl.touk.ticket.booking.demo.data.movie;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.touk.ticket.booking.demo.data.screening.Screening;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Getter
@Builder
@Entity
@Table(name = "Movie")
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

	@Id
	@Column(name = "MovieID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "Title", nullable = false)
	private String title;

	@Column(name = "Description", nullable = false)
	private String description;

	@Column(name = "Director", nullable = false)
	private String director;

	@Column(name = "Duration", nullable = false)
	private Integer duration;

	@OneToMany(mappedBy = "movie")
	private Set<Screening> screening;
}
