
package acme.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.URL;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class SpecificationSheet extends DomainEntity {

	// Serialization identifier -----------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes --------------------------------------------------------------

	@Column(unique = true)
	@NotNull
	@Min(0)
	private Integer				indexer;

	@NotBlank
	private String				title;

	@NotBlank
	private String				description;

	@URL
	private String				photo;

	@NotNull
	@Valid
	@ManyToOne(optional = false)
	private Item				item;

}
