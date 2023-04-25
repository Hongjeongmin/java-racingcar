package study.carrace;

import study.car.Car;
import study.input.Input;
import study.util.Randomizer;

public class CarRaceImpl implements CarRace {

  private final Input carInput;
  private final Input countInput;
  private final Randomizer randomizer;

  public CarRaceImpl(Input carInput, Input countInput, Randomizer randomizer) {
    this.carInput = countInput;
    this.countInput = countInput;
    this.randomizer = randomizer;
  }

  @Override
  public String run() {
    String carsStr = carInput.getInput("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    int tryCount = Integer.parseInt(countInput.getInput("시도할 회수는 몇 회 인가요?"));

    Car[] cars = Car.createCarsAsStr(carsStr);
    RaceGame raceGame = new RaceGameImpl(cars, tryCount, randomizer);
    Race[] races = raceGame.process();

    StringBuffer sb = new StringBuffer();

    sb.append("\n").append("실행 결과").append("\n");

    for (int i = 1; i <= tryCount; i++) {
      for (Race race : races) {
        sb.append(race.currentRace(i)).append("\n");
      }
      sb.append("\n");
    }

    return sb.toString();
  }

}
