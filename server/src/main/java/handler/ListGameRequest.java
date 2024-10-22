package handler;

import java.util.Collection;

import model.GameFullData;

public record ListGameRequest(Collection<GameFullData> games) { 
}
