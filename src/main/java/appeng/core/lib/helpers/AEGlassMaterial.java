/*
 * This file is part of Applied Energistics 2.
 * Copyright (c) 2013 - 2014, AlgorithmX2, All rights reserved.
 *
 * Applied Energistics 2 is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Applied Energistics 2 is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Applied Energistics 2.  If not, see <http://www.gnu.org/licenses/lgpl>.
 */

package appeng.core.lib.helpers;


import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;


public class AEGlassMaterial extends Material
{

	public static final AEGlassMaterial INSTANCE = ( new AEGlassMaterial( MapColor.AIR ) );

	public AEGlassMaterial( final MapColor color )
	{
		super( color );
	}

	@Override
	public boolean isSolid()
	{
		return false;
	}

	@Override
	public boolean isOpaque()
	{
		return false;
	}
}