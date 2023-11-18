package lotto.model.strategy

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldNotBeIn

class LottoNumberRandomWithExceptStrategyTest : StringSpec({
    "지정한 숫자를 제외하고 로또번호를 생성해주는 클래스를 작성" {
        val strategy = LottoNumberRandomWithExceptStrategy(setOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
        (1..100).forEach { _ ->
            strategy.pick() shouldNotBeIn setOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        }
    }
})
