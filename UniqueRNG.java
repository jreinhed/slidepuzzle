// Copyright (c) 2020 Johan Reinhed <jreinhed@protonmail.com>
// 
// Permission to use, copy, modify, and/or distribute this software for any
// purpose with or without fee is hereby granted, provided that the above
// copyright notice and this permission notice appear in all copies.
// 
// THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
// WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
// MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
// ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
// WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
// ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
// OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.

import java.util.Random;
import java.util.List;
import java.util.ArrayList;

class UniqueRNG {
	private Integer[] numList;

	public Integer[] getNumList() {
		return numList;
	}

	public UniqueRNG(int num) {
		numList = new Integer[num];
		Random rand = new Random();
		List<Integer> used = new ArrayList<Integer>();

		for (int i = 0; i < num; i++) {
			do {
				numList[i] = rand.nextInt(num) + 1;
			} while (used.contains(numList[i]));

			used.add(numList[i]);
		}
	}
}
