package lotto

import lotto.model.Game
import lotto.model.LottoNumbers
import lotto.model.Round
import lotto.model.WinningNumbers

object LottoFixture {
    val game1: Game = gameOf(1, 2, 3, 4, 5, 6)
    val game2: Game = gameOf(7, 8, 9, 10, 11, 12)
    val game3: Game = gameOf(1, 11, 21, 31, 41, 31, 22)
    val game4: Game = gameOf(2, 22, 32, 42, 43, 44)
    val Round: Round = Round(listOf(game1, game2, game3, game4))

    val matched6: WinningNumbers = winningNumbersOf(1, 2, 3, 4, 5, 6)
    val matched5: WinningNumbers = winningNumbersOf(2, 3, 4, 5, 6, 37)
    val matched4: WinningNumbers = winningNumbersOf(3, 4, 5, 6, 37, 38)
    val matched3: WinningNumbers = winningNumbersOf(4, 5, 6, 37, 38, 39)

    fun gameOf(vararg values: Int): Game {
        return Game(LottoNumbers(values))
    }

    private fun winningNumbersOf(vararg values: Int): WinningNumbers {
        return WinningNumbers(LottoNumbers(values))
    }
}
