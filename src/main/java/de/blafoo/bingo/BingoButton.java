package de.blafoo.bingo;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;

/**
 * Erweiterung des normalen Buttons zur Darstellung verschiedener Zustände
 * Button hat beim Starten die normale Farbe
 * Beim Aulösen eines ClickEvents wird der Button blau und ein Daumen-Emote erscheint
 */
public class BingoButton extends Button {
	
	private static final long serialVersionUID = -6406557376556850944L;
	
	/** Zustand */
	
	private Boolean checked = Boolean.FALSE;
	
	/** Spalte */
	private int col;
	
	/** Zeile */
	private int row;
	
	public BingoButton(int col, int row, String text, ComponentEventListener<ClickEvent<Button>> listener) {
		super(text);
		this.col = col;
		this.row = row;

        getElement().setAttribute("theme", "badge");
        getElement().setAttribute("title", text);   // for mouseover
		addThemeVariants(ButtonVariant.LUMO_LARGE);
		
		addClickListener(e -> {
			setChecked(!isChecked());
			listener.onComponentEvent(e);
		});
	}
	
	public Boolean isChecked() {
		return checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
		if ( isChecked()) {
			setIcon(new Icon(VaadinIcon.THUMBS_UP));
			addThemeVariants(ButtonVariant.LUMO_PRIMARY); // Button wird blau
		} else {
			setIcon(null);
			removeThemeVariants(ButtonVariant.LUMO_PRIMARY); // Button erhält wieder die normale Farbe
		}
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

}
