package pl.touk.ticket.booking.demo.common.auditorium;

import pl.touk.ticket.booking.demo.data.auditorium.Auditorium;

import org.springframework.stereotype.Component;

@Component
public class AuditoriumMapper {

	public AuditoriumDto mapEntityToDto(Auditorium auditorium) {
		return AuditoriumDto.builder()
							.id(auditorium.getId())
							.name(auditorium.getName())
							.build();
	}
}
