package eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty;

import eu.jpereira.trainings.designpatterns.structural.adapter.exceptions.CodeMismatchException;
import eu.jpereira.trainings.designpatterns.structural.adapter.exceptions.IncorrectDoorCodeException;
import eu.jpereira.trainings.designpatterns.structural.adapter.model.Door;
import eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty.exceptions.CannotChangeCodeForUnlockedDoor;
import eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty.exceptions.CannotChangeStateOfLockedDoor;
import eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty.exceptions.CannotUnlockDoorException;

public class ThirdPartyDoorAdaper extends ThirdPartyDoor implements Door {

	@Override
	public void open(String code) throws IncorrectDoorCodeException {
		try {
			this.unlock(code);
		} catch (CannotUnlockDoorException e1) {
			throw new IncorrectDoorCodeException();
		}
	}

	@Override
	public void close() {
		try {
			setState(DoorState.OPEN);
		} catch (CannotChangeStateOfLockedDoor e) {}
	}

	@Override
	public boolean isOpen() {
		if (!getState().equals(DoorState.OPEN))
			return true;
		else
			return false;
	}

	@Override
	public void changeCode(String oldCode, String newCode,
			String newCodeConfirmation) throws IncorrectDoorCodeException,
			CodeMismatchException {
		if(!newCode.equals(newCodeConfirmation))
			throw new CodeMismatchException();
		try {
			this.setNewLockCode(newCode);
		} catch (CannotChangeCodeForUnlockedDoor e) {
			try {
				this.unlock(oldCode);
				try {
					this.setNewLockCode(newCode);
				} catch (CannotChangeCodeForUnlockedDoor e1) {
					new CodeMismatchException();
				}
			} catch (CannotUnlockDoorException e1) {
				throw new IncorrectDoorCodeException();
			}
		}
		
		
	}

	@Override
	public boolean testCode(String code) {
		try {
			this.unlock(code);
			this.lock();
			return true;
		} catch (CannotUnlockDoorException e) {
			return false;
		}
		
	}

}
