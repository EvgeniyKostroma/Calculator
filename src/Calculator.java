public class Calculator implements Operations {
    private boolean isRoman;

    public Calculator() {
        this.isRoman = false;
    }

    @Override
    public String sum(String operation) throws MyException {
        String[] split = operation.split("\\+");
        if (!isOperationSplitCorrect(split)) {
            throwInputException();
        }
        String firstNumber = split[0].trim().toUpperCase();
        String secondNumber = split[1].trim().toUpperCase();
        if (Numbers.numbers.containsKey(firstNumber)) {
            if (!isRomanNumberLimit(firstNumber)) {
                throwInputRangeException();
            }
            if (Numbers.numbers.containsKey(secondNumber)) {
                if (!isRomanNumberLimit(secondNumber)) {
                    throwInputRangeException();
                }
                int result = Integer.parseInt(Numbers.numbers.get(firstNumber)) + Integer.parseInt(Numbers.numbers.get(secondNumber));
                for (String key : Numbers.numbers.keySet()) {
                    if (Numbers.numbers.get(key).equals(String.valueOf(result)))
                        return key;
                }
            }
        } else {
            if (isNumberCorrect(firstNumber, secondNumber)) {
                if (isNumberLimit(firstNumber)) {
                    if (isNumberLimit(secondNumber)) {
                        return String.valueOf(Integer.parseInt(firstNumber) + Integer.parseInt(secondNumber));
                    } else {
                        throwInputRangeException();
                    }
                } else {
                    throwInputRangeException();
                }
            }
        }
        return null;
    }

    @Override
    public String sub(String operation) throws MyException {
        String[] split = operation.split("\\-");
        if (!isOperationSplitCorrect(split)) {
            throwInputException();
        }
        String firstNumber = split[0].trim().toUpperCase();
        String secondNumber = split[1].trim().toUpperCase();
        if (Numbers.numbers.containsKey(firstNumber)) {
            if (!isRomanNumberLimit(firstNumber)) {
                throwInputRangeException();
            }
            if (Numbers.numbers.containsKey(secondNumber)) {
                if (!isRomanNumberLimit(secondNumber)) {
                    throwInputRangeException();
                }
                int result = Integer.parseInt(Numbers.numbers.get(firstNumber)) - Integer.parseInt(Numbers.numbers.get(secondNumber));
                if (result <= 0) {
                    throwZeroBelowException();
                }
                for (String key : Numbers.numbers.keySet()) {
                    if (Numbers.numbers.get(key).equals(String.valueOf(result)))
                        return key;
                }
            }
        } else {
            if (isNumberCorrect(firstNumber, secondNumber)) {
                if (isNumberLimit(firstNumber)) {
                    if (isNumberLimit(secondNumber)) {
                        return String.valueOf(Integer.parseInt(firstNumber) - Integer.parseInt(secondNumber));
                    } else {
                        throwInputRangeException();
                    }
                } else {
                    throwInputRangeException();
                }
            }
        }
        return null;
    }

    @Override
    public String mul(String operation) throws MyException {
        String[] split = operation.split("\\*");
        if (!isOperationSplitCorrect(split)) {
            throwInputException();
        }
        String firstNumber = split[0].trim().toUpperCase();
        String secondNumber = split[1].trim().toUpperCase();
        if (Numbers.numbers.containsKey(firstNumber)) {
            if (!isRomanNumberLimit(firstNumber)) {
                throwInputRangeException();
            }
            if (Numbers.numbers.containsKey(secondNumber)) {
                if (!isRomanNumberLimit(secondNumber)) {
                    throwInputRangeException();
                }
                int result = Integer.parseInt(Numbers.numbers.get(firstNumber)) * Integer.parseInt(Numbers.numbers.get(secondNumber));
                for (String key : Numbers.numbers.keySet()) {
                    if (Numbers.numbers.get(key).equals(String.valueOf(result)))
                        return key;
                }
            }
        } else {
            if (isNumberCorrect(firstNumber, secondNumber)) {
                if (isNumberLimit(firstNumber)) {
                    if (isNumberLimit(secondNumber)) {
                        return String.valueOf(Integer.parseInt(firstNumber) * Integer.parseInt(secondNumber));
                    } else {
                        throwInputRangeException();
                    }
                } else {
                    throwInputRangeException();
                }
            }
        }
        return null;
    }

    @Override
    public String div(String operation) throws MyException {
        String[] split = operation.split("\\/");
        if (!isOperationSplitCorrect(split)) {
            throwInputException();
        }
        String firstNumber = split[0].trim().toUpperCase();
        String secondNumber = split[1].trim().toUpperCase();
        if (Numbers.numbers.containsKey(firstNumber)) {
            if (!isRomanNumberLimit(firstNumber)) {
                throwInputRangeException();
            }
            if (Numbers.numbers.containsKey(secondNumber)) {
                if (!isRomanNumberLimit(secondNumber)) {
                    throwInputRangeException();
                }
                int result = Integer.parseInt(Numbers.numbers.get(firstNumber)) / Integer.parseInt(Numbers.numbers.get(secondNumber));
                for (String key : Numbers.numbers.keySet()) {
                    if (Numbers.numbers.get(key).equals(String.valueOf(result)))
                        return key;
                }
            }
        } else {
            if (isNumberCorrect(firstNumber, secondNumber)) {
                if (isNumberLimit(firstNumber)) {
                    if (isNumberLimit(secondNumber)) {
                        return String.valueOf(Integer.parseInt(firstNumber) / Integer.parseInt(secondNumber));
                    } else {
                        throwInputRangeException();
                    }
                } else {
                    throwInputRangeException();
                }
            }
        }
        return null;
    }

    private void throwInputException() throws MyException {
        throw new MyException("Ошибка (Неверный формат ввода). Завершение программы!");
    }

    private void throwInputRangeException() throws MyException {
        throw new MyException("Ошибка ввода (Вводимое число больше 10). Завершение программы!");
    }

    private void throwZeroBelowException() throws MyException {
        throw new MyException("Нельзя получить значение римских цифр <= 0. Завершение программы!");
    }

    private boolean isOperationSplitCorrect(String[] splitArray) {
        return splitArray.length == 2;
    }

    private boolean isRomanNumberLimit(String number) {
        return Integer.parseInt(Numbers.numbers.get(number)) <= Numbers.LIMIT_TO_INPUT;
    }

    private boolean isNumberLimit(String number) {
        return Integer.parseInt(number) <= Numbers.LIMIT_TO_INPUT;
    }

    private boolean isNumberCorrect(String firstN, String secondN) throws MyException {
        try {
            int first = Integer.parseInt(firstN);
            int second = Integer.parseInt(secondN);
        } catch (NumberFormatException e) {
            throwInputException();
            return false;
        }
        return true;
    }

}