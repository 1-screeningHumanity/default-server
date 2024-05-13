package ScreeningHumanity.defaultserver.adaptor.out.infrastructure.mysql.entity;

import ScreeningHumanity.defaultserver.domain.Example;
import ScreeningHumanity.defaultserver.global.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "example")
public class ExampleEntity extends BaseEntity {
    //해당 코드는 Entity 자체에서 유효성 검증을 진행한다.
    //또한, DB에 column 명을 지정하고 nullable 속성 등을 지정한다.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    @NotBlank
    @Size(min = 2, max = 20)
    private String name;

    @Column(name = "email", nullable = true)
    @Email
    private String email;

    /**
     * 현재 Domain 이름이 Example 이라 Param 값이 이상하지만, 실제 도메인 적용시 가독성 향상 예정.
     * ex) public static MemberEntity toMemberEntityFrom(Member member)
     *      Member 도메인을 MemberEntity로 변환 하겠다.
     *  Entity 로의 Mapping은 데이터 무결성을 위해서 Model Mapper 사용 지양함.
     * @param example (domain)
     * @return ExampleEntity
     */
    public static ExampleEntity toEntityFrom(Example example){
        return ExampleEntity
                .builder()
                .email(example.getEmail())
                .name(example.getName())
                .build();
    }
}
