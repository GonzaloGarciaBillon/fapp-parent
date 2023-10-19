package cl.fapp.common.domain;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class RangosResumenRVD {
	private List<Rango> foliosUtilizados;
	private List<Rango> foliosAnulados;
	private Integer totalUtilizados;
	private Integer totalAnulados;
}
