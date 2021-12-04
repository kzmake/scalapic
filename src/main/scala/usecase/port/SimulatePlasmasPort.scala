package usecase.port

import usecase.port.{Port, InputData, OutputData}

case class SimulatePlasmasInputData()  extends InputData
case class SimulatePlasmasOutputData() extends OutputData

trait SimulatePlasmasPort extends Port[SimulatePlasmasInputData, SimulatePlasmasOutputData]
